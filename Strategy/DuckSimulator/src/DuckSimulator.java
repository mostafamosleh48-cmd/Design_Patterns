// Behavior interfaces
interface FlyBehavior {
    void fly();
}

interface QuackBehavior {
    void quack();
}

// Concrete Fly behaviors
class FlyWithWings implements FlyBehavior {
    public void fly() { System.out.println("I'm flying with wings!"); }
}
class FlyNoWay implements FlyBehavior {
    public void fly() { System.out.println("I can't fly."); }
}
class FlyRocketPowered implements FlyBehavior {
    public void fly() { System.out.println("I'm flying with a rocket!"); }
}

// Concrete Quack behaviors
class Quack implements QuackBehavior {
    public void quack() { System.out.println("Quack!"); }
}
class Squeak implements QuackBehavior {
    public void quack() { System.out.println("Squeak!"); }
}
class MuteQuack implements QuackBehavior {
    public void quack() { System.out.println("<<silence>>"); }
}

// Abstract Duck (delegates to behavior objects)
abstract class Duck {
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public Duck() {}

    public abstract void display();

    public void performFly() {
        if (flyBehavior != null) flyBehavior.fly();
        else System.out.println("No fly behavior assigned.");
    }

    public void performQuack() {
        if (quackBehavior != null) quackBehavior.quack();
        else System.out.println("No quack behavior assigned.");
    }

    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }

    // These are the key methods: change behavior at runtime
    public void setFlyBehavior(FlyBehavior fb) {
        this.flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        this.quackBehavior = qb;
    }
}

// Concrete ducks
class MallardDuck extends Duck {
    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    public void display() {
        System.out.println("I'm a Mallard duck");
    }
}

class RubberDuck extends Duck {
    public RubberDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squeak();
    }

    public void display() {
        System.out.println("I'm a Rubber duck");
    }
}

// Demo
public class DuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performFly();    // I'm flying with wings!
        mallard.performQuack();  // Quack!

        System.out.println("-- Give the mallard a rocket --");
        mallard.setFlyBehavior(new FlyRocketPowered());
        mallard.performFly();    // I'm flying with a rocket!

        Duck rubber = new RubberDuck();
        rubber.display();
        rubber.performFly();     // I can't fly.
        rubber.performQuack();   // Squeak!

        System.out.println("-- Teach the rubber duck to quack like a real duck --");
        rubber.setQuackBehavior(new Quack());
        rubber.performQuack();   // Quack!
    }
}
