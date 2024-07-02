import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/*Primeiramente muito obrigado pela chance de estar nessa etapa da seletiva.
* As funções estão sendo invocadas pela ordem das questões do desafio*/


public class Principal {

    static DecimalFormat milhar = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    static void AddFuncionarios(ArrayList<Funcionario> listaFuncionario) {
        listaFuncionario.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        listaFuncionario.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        listaFuncionario.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        listaFuncionario.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        listaFuncionario.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        listaFuncionario.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        listaFuncionario.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        listaFuncionario.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        listaFuncionario.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        listaFuncionario.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
    }

    static void removeJoao(ArrayList<Funcionario> listaFuncionario) {
        for (int i = 0; i < listaFuncionario.size(); i++) {
            Funcionario funcionario = listaFuncionario.get(i);
            if (funcionario.getNome().equals("João")) {
                listaFuncionario.remove(i);
                System.out.println("Funcionário João removido com Sucesso !\n");
            }
        }
    }

    static void listarFuncionarios(ArrayList<Funcionario> listaFuncionario) {


        for (Funcionario funcionario : listaFuncionario) {
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Data de Nascimento: " + funcionario.getData_nasc().format(formatter));
            System.out.println("Salário: " + milhar.format(funcionario.getSalario()));
            System.out.println("Função: " + funcionario.getFuncao());
            System.out.println("----------------------------------");
        }
    }

    static void atualizar10Porcento(ArrayList<Funcionario> listaFuncionario) {

        for (Funcionario funcionario : listaFuncionario) {
            BigDecimal novoValor = funcionario.getSalario().multiply(BigDecimal.valueOf(0.1));
            funcionario.setSalario(funcionario.getSalario().add(novoValor));
        }

    }

    static void mapeamento(ArrayList<Funcionario> listaFuncionario) {
        Map<String, List<Funcionario>> FuncionarioPorFuncao = listaFuncionario.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));

        FuncionarioPorFuncao.forEach((funcao, listaFuncao) -> {
            System.out.println("Função: " + funcao);
            listaFuncao.forEach(funcionarios -> System.out.println("- " + funcionarios.getNome()));
            System.out.println();
        });
    }

    static void ani10E12(ArrayList<Funcionario> listaFuncionario) {

        System.out.println("O(s) funcionário(s) que celebra(m) aniversário em outubro e dezembro é/são: \n");
        for (Funcionario funcionario : listaFuncionario) {
            if (funcionario.getData_nasc().getMonthValue() == 10 || funcionario.getData_nasc().getMonthValue() == 12) {
                System.out.println("Nome: " + funcionario.getNome());
            }
        }

    }

    static void maiorIdade(ArrayList<Funcionario> listaFuncionario) {
        Pessoa velho = listaFuncionario.get(0);
        for (Funcionario funcionario : listaFuncionario) {
            if (funcionario.getData_nasc().isBefore(velho.getData_nasc())) {
                velho = funcionario;
            }
        }

        int idade = Period.between(velho.getData_nasc(), LocalDate.now()).getYears();
        System.out.println("\nO funcionário de maior idade na empresa é o " + velho.getNome() + " que Possui " + idade + "anos");
    }

    static void ordemAlfabetica(ArrayList<Funcionario> listaFuncionario) {
        System.out.println("\nLISTA EM ORDEM ALFABÉTICA: \n");
        listaFuncionario.sort(Comparator.comparing(Funcionario::getNome));


    }

    static void totalSalario(ArrayList<Funcionario> listaFuncionario) {
        BigDecimal total = BigDecimal.ZERO;
        for (Funcionario funcionario : listaFuncionario) {
            total = total.add(funcionario.getSalario());
        }

        System.out.println("O total dos salários dos funcionários: " + milhar.format(total));
    }

    private static void imprimirSalariosMinimos(ArrayList<Funcionario> listaFuncionario) {
        for (Funcionario funcionario : listaFuncionario) {
            BigDecimal quantSalaMin = funcionario.getSalario().divide(new BigDecimal("1212.00"), 0, RoundingMode.FLOOR);
            System.out.println(
                    "\n O(A) funcionário(a) " + funcionario.getNome() + " ganha " + quantSalaMin + " Salário(s) Mínimo");
        }

    }

    public static void main(String[] args) {
        ArrayList<Funcionario> listaFuncionario = new ArrayList<>();

        AddFuncionarios(listaFuncionario);

        removeJoao(listaFuncionario);

        listarFuncionarios(listaFuncionario);

        atualizar10Porcento(listaFuncionario);

        mapeamento(listaFuncionario);

        ani10E12(listaFuncionario);

        maiorIdade(listaFuncionario);

        ordemAlfabetica(listaFuncionario);

        listarFuncionarios(listaFuncionario);

        totalSalario(listaFuncionario);

        imprimirSalariosMinimos(listaFuncionario);


    }
}
