
int ccc = 2;
int ccc1 = 3*3*3*3 + 22*ccc;
char ggg;

void func_without_args()
{
    int a;
    complex b;

    b = 2+2i;
    b = 2i;
    b = 2.2i;
    b = -2.2i;
    b = 2.2 + 22i;
    b = 0x33 + 0i;
    b = -0x33 - 33i;
    b = -32 + 0.22i;

    a = 22 + a + a;
}

int func_with_one_arg(int arg)
{
    int a = arg*2;
    return a;
}

int func_with_two_args(int arg1,int arg2)
{
    int a = arg1*123+arg2*987;
    a = 1;
    a--;

    if (true) {
    } else {
        goto labelka;
    }

    // print(a);

    --a;
labelka#

    return a;
}

int main()
{
    int i;
//    int abc;
//    int arr[10];
    func_with_two_args(1,2);
    i--;
    --i;
    for (i=9; i<22; i++) {
//        int j;
//        int ok;
    }

    while (true) {
        func_without_args();
    }
    2<5 ? (i = 0) : (i = 1);

    return 0;
}

int a;

int manyScopes(int a) {
    if (true) {
        int a;
        while (true) {
            int a;
            int j;
            for (j = 0; j < 10; j++) {
                a++;
            }
        }
        a++;
    } else {
    }
    while (true) {
        int c;
        while (false) {
            c++;
        }
        a--;
    }
    while (true) {
        a++;
    }
    a++;
    return 0;
}

int test() {
    int c;
    c++;
    return c;
}