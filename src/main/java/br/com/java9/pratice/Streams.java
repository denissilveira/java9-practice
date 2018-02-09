package br.com.java9.pratice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        Map<Integer, String> weekDays = 
                Map.of(1, "Domingo", 
                       2, "Segunda", 
                       3, "Terça", 
                       4, "Quarta", 
                       5, "Quinta", 
                       6, "Sexta", 
                       7, "Sábado");

        List<String> dayNames = weekDays.entrySet().stream()
                                    .flatMap(e -> Stream.ofNullable(e.getValue())) // ofNullable remove o valor nulo e evita um NullPointerException
                                    .map(s  ->  s.substring(0,3))
                                    .collect(Collectors.toList());
        System.out.println(dayNames);

        List<String> names = List.of("Jose", "Maria", "Joao");
        names.forEach(System.out::println);
        
        // pula os 5 primeiros valores
        IntStream.range(0, 10)
            .skip(5)
            .forEach(System.out::println);
        
        // limita a impressão de apenas 3 numeros
        IntStream.range(0,10)               
            .limit(3)               
            .forEach(System.out::println);
        
        // remove todos os numeros até encontrar um maior do que 5 (remove enquanto encontrar a condição, depois passa a exibir todos)
        IntStream.range(0,10)               
            .dropWhile(e -> e <=  5)              
            .forEach(System.out::println);
        
        // mantém todos os numeros até encontrar um maior do que 5 (mantém enquanto encontrar a condição, depois passa a exibir todos)
        IntStream.range(0,10)               
            .takeWhile(e -> e <=  5)              
            .forEach(System.out::println);
        
        // remove todas as Strings que antecedem a palavra "no"
        Stream.of("muitas", "novidades", "no", "java")
            .dropWhile(s -> !s.equals("no"))
            .forEach(System.out::println);
        
        // novo modelo de iteração, algo semelhante ao antigo for
        Stream
            .iterate(1, n -> n <= 10, n -> n + 1)
            .forEach(System.out::println);
        
        // outra forma de criar o iterate
        Stream
            .iterate(1, n -> n + 1)
            .limit(10)
            .forEach(System.out::println);

    }
}
