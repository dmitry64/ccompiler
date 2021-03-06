package edu.eltech.moevm.assembler;

import java.util.ArrayList;

/**
 * Created by lazorg on 12/21/15.
 */
public class AsmCode {
    private ArrayList<String> header;
    private ArrayList<String> data;
    private ArrayList<String> bss;
    private ArrayList<String> code;
    private ArrayList<String> footer;

    private int stringid;
    private int tempid;


    public AsmCode() {
        stringid = 0;
        tempid = 0;
        header = new ArrayList<>();
        data = new ArrayList<>();
        bss = new ArrayList<>();
        code = new ArrayList<>();
        footer = new ArrayList<>();

        header.add("global _start\n\n");

        data.add("section .data\n");
        data.add("float_buff:dd 0\n");
        data.add("double_buff:dd 0,0\n");

        bss.add("section .bss\n" +
                "\tprintbuf resb 10\n");

        code.add("section .text\n");

        code.add("itoa:\n" +
                "\tenter 4,0\n" +
                "\tlea r8,[printbuf+10]\n" +
                "\tmov rcx,10\n" +
                "\tmov [rbp-4],dword 0\n" +
                "\n" +
                "\t.divloop:\n" +
                "\txor rdx,rdx\n" +
                "\tidiv rcx\n" +
                "\tadd rdx,0x30\n" +
                "\tdec r8\n" +
                "\tmov byte [r8],dl\n" +
                "\tinc dword [rbp-4]\n" +
                "\n" +
                "\tcmp rax,0\n" +
                "\tjnz .divloop\n" +
                "\n" +
                "\tmov rax,r8\n" +
                "\tmov rcx,[rbp-4]\n" +
                "\n" +
                "\tleave\n" +
                "\tret\n" +
                "\n" +
                "clean_buf:\n" +
                "\tlea r8,[printbuf+10]\n" +
                "\tmov rcx,10\n" +
                "\t.clear_loop:\n" +
                "\tmov byte[r8],0\n" +
                "\tdec r8\n" +
                "\tdec rcx\n" +
                "\tcmp rcx,0\n" +
                "\tjnz .clear_loop\n" +
                "\txor rcx,rcx\n" +
                "\txor r8,r8\n" +
                "\tret\n" +
                "\n" +
                "print_num:\n" +
                "\tpush rax\n" +
                "\tpush rbx\n" +
                "\tpush rcx\n" +
                "\tpush rdx\n" +
                "\tpush r8\n" +
                "\tcall clean_buf\n" +
                "\tcall itoa\n" +
                "\tmov eax, 4\n" +
                "    mov ebx, 1\n" +
                "    mov ecx, printbuf\n" +
                "    mov edx, 10\n" +
                "    int 0x80\n" +
                "    pop r8\n" +
                "    pop rdx\n" +
                "    pop rcx\n" +
                "    pop rbx\n" +
                "    pop rax\n" +
                "    ret\n" +
                "\n" +
                "print_str:\n" +
                "\tmov eax, 4\n" +
                "    mov ebx, 1\n" +
                "    int 0x80\n" +
                "    ret\n");

        code.add("_start:\n");
        //code.add("\txor rax,rax\n");
        //code.add("\txor rbx,rbx\n");
        //code.add("\txor rcx,rcx\n");
        //code.add("\txor rdx,rdx\n");

        footer.add("\n" +
                "\tmov\teax, 1\n" +
                "\tmov\tebx, 0\n" +
                "\tint\t0x80");
    }


    public void addCode(String line) {
        code.add(line);
    }

    public void addData(String line) {
        data.add(line);
    }

    public void addBss(String line) {
        bss.add(line);
    }

    public String print() {
        String codeText = new String();
        for (String str : header) {
            codeText += str;
        }
        for (String str : data) {
            codeText += str;
        }
        for (String str : bss) {
            codeText += str;
        }
        for (String str : code) {
            codeText += str;
        }
        for (String str : footer) {
            codeText += str;
        }

        return codeText;
    }

    public ArrayList<String> getCode() {
        return code;
    }

    public void setCode(ArrayList<String> code) {
        this.code = code;
    }

    public int getStringid() {
        stringid++;
        return stringid;
    }

    public int getTempid() {
        tempid++;
        return tempid;
    }
}
