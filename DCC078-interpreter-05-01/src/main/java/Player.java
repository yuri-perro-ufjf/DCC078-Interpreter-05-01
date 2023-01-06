public class Player {
    private double damageBase;
    private double damageBonus;

    public double getDamageBase() {
        return damageBase;
    }

    public void setDamageBase(double damageBase) {
        this.damageBase = damageBase;
    }

    public double getDamageBonus() {
        return damageBonus;
    }

    public void setDamageBonus(double damageBonus) {
        this.damageBonus = damageBonus;
    }

    public double calcFullDamage() {
        return DamageCalculator.calcFullDamage(this.damageBase, this.damageBonus);
    }
}
