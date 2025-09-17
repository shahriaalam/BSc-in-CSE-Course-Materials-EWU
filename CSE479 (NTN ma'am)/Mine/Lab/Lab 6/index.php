<?php
abstract class Meal {
    public $ID;
    private $name;

    public function __construct($ID, $name) {
        $this->ID = $ID;
        $this->name = $name;
    }

    public function getName() {
        return $this->name;
    }

    abstract public function prepare();
}


class Burger extends Meal {
    public function __construct($ID, $name) {
        parent::__construct($ID, $name); 
    }

    public function prepare() {
        return "Preparing Burger...";
    }

    public function wrap($wrapper) {
        return "Wrapping burger in " . $wrapper;
    }
}


class Drinks extends Meal {
    public function __construct($ID, $name) {
        parent::__construct($ID, $name); 
    }

    public function prepare() {
        return "Preparing Drink...";
    }

    public function package($material) {
        return "Packaging drink with " . $material;
    }
}


class VegBurger extends Burger {
    private $ingredients = [];

    public function __construct($ID, $name, $ingredients) {
        parent::__construct($ID, $name);  
        $this->ingredients = $ingredients;
    }

    public function alertClient() {
        return "Veg Burger prepared with the following ingredients: " . implode(", ", $this->ingredients);
    }
}


class ChickenBurger extends Burger {
    public function __construct($ID, $name) {
        parent::__construct($ID, $name);  
    }

    public function sendTokenAlert() {
        return "Chicken Burger is ready! Token alert sent.";
    }
}


class Juice extends Drinks {
    private $ingredients = [];

    public function __construct($ID, $name, $ingredients) {
        parent::__construct($ID, $name); 
        $this->ingredients = $ingredients;
    }

    public function alertClient() {
        return "Juice prepared with the following ingredients: " . implode(", ", $this->ingredients);
    }
}

class SoftDrinks extends Drinks {
    private $brand;

    public function __construct($ID, $name, $brand) {
        parent::__construct($ID, $name);  
        $this->brand = $brand;
    }

    public function sendTokenAlert() {
        return $this->brand . " Soft Drink is ready! Token alert sent.";
    }
}


$vegBurger = new VegBurger(1, 'Veg Burger', ['Lettuce', 'Tomato', 'Cheese']);
$chickenBurger = new ChickenBurger(2, 'Chicken Burger');
$juice = new Juice(3, 'Orange Juice', ['Orange', 'Lemon']);
$softDrink = new SoftDrinks(4, 'Coca-Cola', 'Coca-Cola');

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meal Preparation</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<div class="container">
    <h1>Meal Preparation Details</h1>
   
    <div class="meal">
        <h2><?php echo $vegBurger->getName(); ?></h2>
        <p class="meal-info"><?php echo $vegBurger->prepare(); ?></p>
        <p><?php echo $vegBurger->wrap('paper wrapper'); ?></p>
        <p class="alert"><?php echo $vegBurger->alertClient(); ?></p>
    </div>

    <div class="meal">
        <h2><?php echo $chickenBurger->getName(); ?></h2>
        <p class="meal-info"><?php echo $chickenBurger->prepare(); ?></p>
        <p><?php echo $chickenBurger->wrap('foil wrapper'); ?></p>
        <p class="alert"><?php echo $chickenBurger->sendTokenAlert(); ?></p>
    </div>

    <div class="meal">
        <h2><?php echo $juice->getName(); ?></h2>
        <p class="meal-info"><?php echo $juice->prepare(); ?></p>
        <p><?php echo $juice->package('Plastic Bottle'); ?></p>
        <p class="alert"><?php echo $juice->alertClient(); ?></p>
    </div>

    <div class="meal">
        <h2><?php echo $softDrink->getName(); ?></h2>
        <p class="meal-info"><?php echo $softDrink->prepare(); ?></p>
        <p><?php echo $softDrink->package('Can'); ?></p>
        <p class="alert"><?php echo $softDrink->sendTokenAlert(); ?></p>
    </div>

   
</div>

</body>
</html>
