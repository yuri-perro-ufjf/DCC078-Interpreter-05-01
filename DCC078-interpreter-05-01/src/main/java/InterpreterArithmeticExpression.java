import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class InterpreterArithmeticExpression implements InterpreterExpression {
        private InterpreterExpression initialInterpreter;

        public InterpreterArithmeticExpression(String context) {

            Stack<InterpreterExpression> stackInterpreters = new Stack<>();
            List<String> elements = Arrays.asList(context.split(" "));
            Iterator<String> iterator = elements.iterator();

            while (iterator.hasNext()) {
                String element = iterator.next();
                if (element.matches("\\d+(\\.\\d*)?")) {
                    stackInterpreters.push(new Number(Double.parseDouble(element)));
                } else if (element.equals("+")) {
                    if (!iterator.hasNext())
                        throw new IllegalArgumentException("Invalid Expression");
                    Number leftElement = (Number) stackInterpreters.pop();
                    Number rightElement = new Number(Double.parseDouble(iterator.next()));
                    Addition interpreter = new Addition(leftElement, rightElement);
                    stackInterpreters.push(new Number(interpreter.interpret()));
                } else if (element.equals("-")) {
                    if (!iterator.hasNext())
                        throw new IllegalArgumentException("Invalid Expression");
                    Number leftElement = (Number) stackInterpreters.pop();
                    Number rightElement = new Number(Double.parseDouble(iterator.next()));
                    Subtraction interpreter = new Subtraction(leftElement, rightElement);
                    stackInterpreters.push(new Number(interpreter.interpret()));
                } else if (element.equals("*")) {
                    if (!iterator.hasNext())
                        throw new IllegalArgumentException("Invalid Expression");
                    Number leftElement = (Number) stackInterpreters.pop();
                    Number rightElement = new Number(Double.parseDouble(iterator.next()));
                    Multiplication interpreter = new Multiplication(leftElement, rightElement);
                    stackInterpreters.push(new Number(interpreter.interpret()));
                } else if (element.equals("/")) {
                    if (!iterator.hasNext())
                        throw new IllegalArgumentException("Invalid Expression");
                    Number leftElement = (Number) stackInterpreters.pop();
                    Number rightElement = new Number(Double.parseDouble(iterator.next()));
                    Division interpreter = new Division(leftElement, rightElement);
                    stackInterpreters.push(new Number(interpreter.interpret()));
                } else {
                    throw new IllegalArgumentException("Invalid Expression with element");
                }
            }
            initialInterpreter = stackInterpreters.pop();
        }

        public double interpret() {
            return initialInterpreter.interpret();
        }
}
