public class DamageCalculator {
    public static String formula = "damageBase + 10 * damageBonus";

    public static double calcFullDamage(double damageBase, double damageBonus) {
        String expression;
        expression = formula.replace("damageBase", Double.toString(damageBase));
        expression = expression.replace("damageBonus", Double.toString(damageBonus));
        InterpreterExpression interpreter = new InterpreterArithmeticExpression(expression);
        return interpreter.interpret();
    }
}
