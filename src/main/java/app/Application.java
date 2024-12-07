package app;

import app.annotations.Author;
import app.annotations.MethodInfo;
import app.myUtils.MyArrayUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        Class<?> clazz = MyArrayUtil.class;
        List<Integer> array = new ArrayList<Integer>(100);
        for (int i = 0; i < 100; i++) array.add( (int) (Math.random() * (100 - 20) + 20));

        System.out.print("Unsorted Array: \n" + array.toString());

        List<Integer> sortedArray = MyArrayUtil.mergeSort(array);
        System.out.print("\nSorted Array: \n" + sortedArray.toString() + "\n");
        checkMethodAnnotations(clazz,"mergeSort", List.class);

        Integer target = 71;
        int index = MyArrayUtil.binarySearch(sortedArray, target);
        System.out.println("\nIndex: " + index);
        checkMethodAnnotations(clazz,"binarySearch", List.class, Comparable.class);


//        Stream.of(clazz.getDeclaredMethods()).forEach(s -> {
//            s.setAccessible(true);
//            System.out.println("Method: " + s.getName());
//            Stream.of(s.getAnnotations()).forEach(i -> {
//                if(i instanceof Author) {
//                    System.out.println("Method author is " + ((Author) i).firstName() + " " + ((Author) i).lastName());
//                }
//                else if (i instanceof MethodInfo) {
//                    System.out.println("Information about used method:"
//                    +"\n\tname: " + ((MethodInfo) i).name()
//                    +"\n\treturn type: " + ((MethodInfo) i).type()
//                    +"\n\tdescription: " + ((MethodInfo) i).description());
//                }
//            });
//        });
    }
    public static void checkMethodAnnotations(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
        try{
            Stream.of(clazz.getMethod(methodName, parameterTypes).getAnnotations()).forEach(i -> {
                if (i instanceof Author) {
                    System.out.print("Author of method used above is " + ((Author) i).firstName() + " " + ((Author) i).lastName());
                } else if (i instanceof MethodInfo) {
                    System.out.println("Information about used method:"
                            + "\n\tname: " + ((MethodInfo) i).name()
                            + "\n\treturn type: " + ((MethodInfo) i).type()
                            + "\n\tdescription: " + ((MethodInfo) i).description());
                }
            });
        }catch (NoSuchMethodException e){
            System.out.println("There is no method for the given class, method name or method parameters");
        }
    }
}