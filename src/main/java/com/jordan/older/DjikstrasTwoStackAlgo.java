package com.jordan.older;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DjikstrasTwoStackAlgo {
    /*
    Used to solve the arithmetic operation problem. Solve (1 + ((2 + 3) * (4 * 5)))

    Rules:

    1. Read from left to right
    2. Value: push onto the value stack
    3. left parenthesis: ignore
    4. Right parenthesis: pop one operator and two values;
        Push the result of applying the operator to those values onto the value stack


    Example:

        Value Stack                 Operand Stack
            1                               +
            2                               +
            3

         First ).

       Value Stack                 Operand Stack
            1                               +
            5                                       <-- 2 + 3

       Value Stack                 Operand Stack
            1                               +
            5                               *
            4                               *
            5

         Second ).

       Value Stack                 Operand Stack
            1                               +
            5                               *
            20                                      <--4 * 5

           Third ).

       Value Stack                 Operand Stack
            1                               +
            100                                     <-- 5 * 20

           Fourth ).

       Value Stack                 Operand Stack
            101                                     <-- 100 + 1


     */


    Stack<Double> values;
    Stack<String> operators;

    public DjikstrasTwoStackAlgo(){
        values = new Stack<>();
        operators = new Stack<>();
    }

    public double solve(String operation){
        List<String> operations = Arrays.asList("*", "/", "+", "-", "%");
        for(String s: operation.split(" ")){
            if(operations.contains(s)){
                operators.push(s);
            } else if (s.contains(")")){
                String op = operators.pop();
                Double last;
                switch(op){
                    case "*":
                        values.push(values.pop() * values.pop());
                        break;
                    case "/":
                        last = values.pop();
                        values.push( values.pop() / last);
                        break;
                    case "+":
                        values.push(values.pop() + values.pop());
                        break;
                    case "-":
                        last = values.pop();
                        values.push( values.pop() - last);
                        break;
                    case "%":
                        last = values.pop();
                        values.push( values.pop() % last);
                        break;
                }
            } else if (s.contains("(")){
                //ignore it
            }
            else {
                values.push(Double.parseDouble(s));
            }
        }
        return values.pop();
    }

    public static void main(String[] args){
        DjikstrasTwoStackAlgo algo = new DjikstrasTwoStackAlgo();
//        StdOut.println(algo.solve("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"));

        StdOut.println(algo.solve("( 1 + ( ( 155 + 3 ) * ( 4 * 5 ) ) )"));
    }
}
