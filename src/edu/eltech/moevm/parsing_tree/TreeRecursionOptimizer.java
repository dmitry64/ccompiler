package edu.eltech.moevm.parsing_tree;

import edu.eltech.moevm.autogen.Parser;
import edu.eltech.moevm.common.Nonterminals;

public class TreeRecursionOptimizer implements PTCallback {
    @Override
    public void processElement(PTElement e, int level) {
        if (!(e instanceof PTNode)) {
            return;
        }
        PTNode ptnode = (PTNode) e;
        for (int i = 0; i < ptnode.getElements().size(); i++) {
            PTElement child = ptnode.getElements().get(i);
            if (!(child instanceof PTNode)) {
                continue;
            }
            PTNode ptnodeChild = (PTNode) child;
            switch (ptnodeChild.getNonterminal()) {
                case POSTFIX_EXPRESSION:
                    // childs = ["postfix_expression","INC_OP"]
                    if (ptnodeChild.getElements().size() == 2) {
                        PTElement element0 = ptnodeChild.getElements().get(0);
                        PTElement element1 = ptnodeChild.getElements().get(1);
                        if (element0 instanceof PTNode && ((PTNode) element0).getNonterminal() == Nonterminals.POSTFIX_EXPRESSION && element1 instanceof PTLeaf && ((PTLeaf) element1).getToken() == Parser.INC_OP) {
                            element0.setParent(ptnode);
                            ptnode.insertElementBefore(child, element0);
                            element1.setParent(ptnode);
                            ptnode.insertElementBefore(child, element1);
                            System.out.println("(recursive) removed " + ptnodeChild.getNonterminal());
                            ptnode.remove(child);
                            i--;
                            break;
                        }
                    }
                    // childs = ["postfix_expression","DEC_OP"]
                    if (ptnodeChild.getElements().size() == 2) {
                        PTElement element0 = ptnodeChild.getElements().get(0);
                        PTElement element1 = ptnodeChild.getElements().get(1);
                        if (element0 instanceof PTNode && ((PTNode) element0).getNonterminal() == Nonterminals.POSTFIX_EXPRESSION && element1 instanceof PTLeaf && ((PTLeaf) element1).getToken() == Parser.DEC_OP) {
                            element0.setParent(ptnode);
                            ptnode.insertElementBefore(child, element0);
                            element1.setParent(ptnode);
                            ptnode.insertElementBefore(child, element1);
                            System.out.println("(recursive) removed " + ptnodeChild.getNonterminal());
                            ptnode.remove(child);
                            i--;
                            break;
                        }
                    }
                    break;
                case UNARY_EXPRESSION:
                    // childs = ["INC_OP","unary_expression"]
                    if (ptnodeChild.getElements().size() == 2) {
                        PTElement element0 = ptnodeChild.getElements().get(0);
                        PTElement element1 = ptnodeChild.getElements().get(1);
                        if (element0 instanceof PTLeaf && ((PTLeaf) element0).getToken() == Parser.INC_OP && element1 instanceof PTNode && ((PTNode) element1).getNonterminal() == Nonterminals.UNARY_EXPRESSION) {
                            element0.setParent(ptnode);
                            ptnode.insertElementBefore(child, element0);
                            element1.setParent(ptnode);
                            ptnode.insertElementBefore(child, element1);
                            System.out.println("(recursive) removed " + ptnodeChild.getNonterminal());
                            ptnode.remove(child);
                            i--;
                            break;
                        }
                    }
                    // childs = ["DEC_OP","unary_expression"]
                    if (ptnodeChild.getElements().size() == 2) {
                        PTElement element0 = ptnodeChild.getElements().get(0);
                        PTElement element1 = ptnodeChild.getElements().get(1);
                        if (element0 instanceof PTLeaf && ((PTLeaf) element0).getToken() == Parser.DEC_OP && element1 instanceof PTNode && ((PTNode) element1).getNonterminal() == Nonterminals.UNARY_EXPRESSION) {
                            element0.setParent(ptnode);
                            ptnode.insertElementBefore(child, element0);
                            element1.setParent(ptnode);
                            ptnode.insertElementBefore(child, element1);
                            System.out.println("(recursive) removed " + ptnodeChild.getNonterminal());
                            ptnode.remove(child);
                            i--;
                            break;
                        }
                    }
                    // childs = ["SIZEOF","unary_expression"]
                    if (ptnodeChild.getElements().size() == 2) {
                        PTElement element0 = ptnodeChild.getElements().get(0);
                        PTElement element1 = ptnodeChild.getElements().get(1);
                        if (element0 instanceof PTLeaf && ((PTLeaf) element0).getToken() == Parser.SIZEOF && element1 instanceof PTNode && ((PTNode) element1).getNonterminal() == Nonterminals.UNARY_EXPRESSION) {
                            element0.setParent(ptnode);
                            ptnode.insertElementBefore(child, element0);
                            element1.setParent(ptnode);
                            ptnode.insertElementBefore(child, element1);
                            System.out.println("(recursive) removed " + ptnodeChild.getNonterminal());
                            ptnode.remove(child);
                            i--;
                            break;
                        }
                    }
                    break;
                case DECLARATION_SPECIFIERS:
                    // childs = ["type_specifier","declaration_specifiers"]
                    if (ptnodeChild.getElements().size() == 2) {
                        PTElement element0 = ptnodeChild.getElements().get(0);
                        PTElement element1 = ptnodeChild.getElements().get(1);
                        if (element0 instanceof PTNode && ((PTNode) element0).getNonterminal() == Nonterminals.TYPE_SPECIFIER && element1 instanceof PTNode && ((PTNode) element1).getNonterminal() == Nonterminals.DECLARATION_SPECIFIERS) {
                            element0.setParent(ptnode);
                            ptnode.insertElementBefore(child, element0);
                            element1.setParent(ptnode);
                            ptnode.insertElementBefore(child, element1);
                            System.out.println("(recursive) removed " + ptnodeChild.getNonterminal());
                            ptnode.remove(child);
                            i--;
                            break;
                        }
                    }
                    break;
                case INIT_DECLARATOR_LIST:
                    // childs = ["init_declarator_list","COMMA","init_declarator"]
                    if (ptnodeChild.getElements().size() == 3) {
                        PTElement element0 = ptnodeChild.getElements().get(0);
                        PTElement element1 = ptnodeChild.getElements().get(1);
                        PTElement element2 = ptnodeChild.getElements().get(2);
                        if (element0 instanceof PTNode && ((PTNode) element0).getNonterminal() == Nonterminals.INIT_DECLARATOR_LIST && element1 instanceof PTLeaf && ((PTLeaf) element1).getToken() == Parser.COMMA && element2 instanceof PTNode && ((PTNode) element2).getNonterminal() == Nonterminals.INIT_DECLARATOR) {
                            element0.setParent(ptnode);
                            ptnode.insertElementBefore(child, element0);
                            element1.setParent(ptnode);
                            ptnode.insertElementBefore(child, element1);
                            element2.setParent(ptnode);
                            ptnode.insertElementBefore(child, element2);
                            System.out.println("(recursive) removed " + ptnodeChild.getNonterminal());
                            ptnode.remove(child);
                            i--;
                            break;
                        }
                    }
                    break;
                case DECLARATION_LIST:
                    // childs = ["declaration_list","declaration"]
                    if (ptnodeChild.getElements().size() == 2) {
                        PTElement element0 = ptnodeChild.getElements().get(0);
                        PTElement element1 = ptnodeChild.getElements().get(1);
                        if (element0 instanceof PTNode && ((PTNode) element0).getNonterminal() == Nonterminals.DECLARATION_LIST && element1 instanceof PTNode && ((PTNode) element1).getNonterminal() == Nonterminals.DECLARATION) {
                            element0.setParent(ptnode);
                            ptnode.insertElementBefore(child, element0);
                            element1.setParent(ptnode);
                            ptnode.insertElementBefore(child, element1);
                            System.out.println("(recursive) removed " + ptnodeChild.getNonterminal());
                            ptnode.remove(child);
                            i--;
                            break;
                        }
                    }
                    break;
                case STATEMENT_LIST:
                    // childs = ["statement_list","statement"]
                    if (ptnodeChild.getElements().size() == 2) {
                        PTElement element0 = ptnodeChild.getElements().get(0);
                        PTElement element1 = ptnodeChild.getElements().get(1);
                        if (element0 instanceof PTNode && ((PTNode) element0).getNonterminal() == Nonterminals.STATEMENT_LIST && element1 instanceof PTNode && ((PTNode) element1).getNonterminal() == Nonterminals.STATEMENT) {
                            element0.setParent(ptnode);
                            ptnode.insertElementBefore(child, element0);
                            element1.setParent(ptnode);
                            ptnode.insertElementBefore(child, element1);
                            System.out.println("(recursive) removed " + ptnodeChild.getNonterminal());
                            ptnode.remove(child);
                            i--;
                            break;
                        }
                    }
                    break;
                case TRANSLATION_UNIT:
                    // childs = ["translation_unit","external_declaration"]
                    if (ptnodeChild.getElements().size() == 2) {
                        PTElement element0 = ptnodeChild.getElements().get(0);
                        PTElement element1 = ptnodeChild.getElements().get(1);
                        if (element0 instanceof PTNode && ((PTNode) element0).getNonterminal() == Nonterminals.TRANSLATION_UNIT && element1 instanceof PTNode && ((PTNode) element1).getNonterminal() == Nonterminals.EXTERNAL_DECLARATION) {
                            element0.setParent(ptnode);
                            ptnode.insertElementBefore(child, element0);
                            element1.setParent(ptnode);
                            ptnode.insertElementBefore(child, element1);
                            System.out.println("(recursive) removed " + ptnodeChild.getNonterminal());
                            ptnode.remove(child);
                            i--;
                            break;
                        }
                    }
                    break;
            }
        }
    }
}
