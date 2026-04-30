import java.util.Scanner;
void main() {
Scanner entrada = new Scanner(System.in);
    int  i = 0, soma = 0, dv1 = 0, dv2 = 0, soma2 = 0, num = 0;
    int  resto = 0, resto2 = 0;
    IO.println("Digite o CPF: ");
    String cpf = entrada.nextLine();
    if (cpf.length() != 11){
        IO.println("CPF inválido!");
        return;
    }
    int digitoCpf = cpf.charAt(9) - '0';
    int digitoCpf2 = cpf.charAt(10) - '0';
    char  primeiro = cpf.charAt(0);
    boolean todosIguais = true;
    for (i  = 1; i < cpf.length(); i ++){
        if  (cpf.charAt(i) != primeiro){
            todosIguais = false;
            break;
        }
    }
    if (todosIguais){
        IO.println("CPF inválido!");
        return;
    }

    for (i = 0; i < 9; i++) {
        num = cpf.charAt(i) - '0';
        soma += num * (10-i);
    }
    resto = soma % 11;
    if (resto < 2 ){
        dv1 = 0;
    }else {
        dv1 = 11 - resto;
    }
    if (dv1 != digitoCpf) {
        System.out.println("CPF inválido");
        return;
    }
    for (i = 0; i < 10; i++) {
        if (i < 9) {
          num = cpf.charAt(i) - '0';
        } else {
            num = dv1;
        }
        soma2 += num * (11-i);
    }
    resto2 = soma2 % 11;
    if (resto2 < 2 ){
        dv2 = 0;
    }else {
        dv2 = 11 - resto2;
    }
    if (dv2 != digitoCpf2) {
        System.out.println("CPF inválido");
        return;
    }
    IO.println("CPF válido");
}