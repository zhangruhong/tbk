package com.bukaxi.tbk.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {

    public static void main(String[] args){
        Predicate<Integer> atLeast5 = x -> x > 5;

        BinaryOperator<Long> add = (x,y) -> x + y;

        Map<String ,Integer> map = new HashMap<>();
        map.put("aaaa",1);
        map.put("bbbbb",1);

        List<String> list = map.keySet().stream().collect(Collectors.toList());

        list.forEach( l -> {
            System.out.println("1");
            System.out.println(l);
        });
        
        List<Integer> list2 = Stream.of(Arrays.asList(1,2), Arrays.asList(3,4)).flatMap( n -> n.stream()).collect(Collectors.toList());
        System.out.println(list2);
        
        List<List<String>> str = Arrays.asList(Arrays.asList("a","b"),Arrays.asList("c","d"));
        str.stream().filter( lis -> null != lis).forEach( l -> {
        	System.out.println(l);
        });
        
        str.stream().filter( lis -> null != lis).flatMap( List::stream).forEach( l -> {
        	System.out.println(l);
        });
        
        Arrays.asList("a","b").contains(null);
        
        Set<String> set = new HashSet<>();
        set.add("a");
        System.out.println(set.contains(null));

        System.out.println(Arrays.asList(1,2).contains(0));
        
        Optional<String> a = Optional.of("a");
        System.out.println(a.get());
        
        Optional emptyOptional = Optional.empty();
        Optional alsoEmpty = Optional.ofNullable(null);
        
        System.out.println(emptyOptional.isPresent());
        System.out.println(a.isPresent());
        
        System.out.println(emptyOptional.orElse("b"));
        System.out.println(emptyOptional.orElseGet(() -> "c"));
    }
    
//    @Test
//    public void testM(){
//    	List<Track> list = Stream.of(new Track("100",100),new Track("200",200),new Track("300",300)).collect(Collectors.toList());
//    	Arrays.asList("a","b").contains(null);
//    	
////    	String dd = list.stream().min(Comparator.comparing( t -> t.)).get();
////    	System.out.println(dd);
//    }


}


