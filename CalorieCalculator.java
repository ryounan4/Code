import java.util.Scanner;

class CalorieCalculator {

  public static int numCals() {
    Scanner cool = new Scanner(System.in);
    int calories = 0; // Initialize calories

    System.out.println(
        "Hello, I'm your fitness friend! Please answer the following prompts to help find a suitable number of calories and macros for you to consume each day in order to gain muscle and maintain your current weight.");
    System.out.println("Are you a male or female?");
    String gender = cool.nextLine();// stores the gender that the user inputs
    gender = gender.toLowerCase();
    System.out.println("Please enter your current weight in pounds:");
    double weight = cool.nextDouble();// stores the weight that the user inputs
    System.out.println("Please enter your age:");
    int age = cool.nextInt();// stores the age that the user inputs
    System.out.println("Please enter your height in inches:");// stores the height that the user inputs
    int height = cool.nextInt();// stores the height that the user inputs
    System.out.println("Please choose one of the daily activity levels that best represents you:");
    System.out.println("1 (little to no exercise)");
    System.out.println("2 (light exercise/sports 1-3 days per week)");
    System.out.println("3 (moderate exercise/sports 3-5 days per week)");
    System.out.println("4 (hard exercise/sports 6-7 days per week)");
    System.out.println("5 (very hard exercise/sports & physical job or training twice a day)");
    int activityLevel = cool.nextInt();// stores the user's activity level

    if (gender.equals("male")) {
      calories = (int) ((6.23762 * weight) + (12.7084 * height) - (6.755 * age) + 66.473); // Uses the Harris-Benedict
                                                                                           // equation
                                                                                           // to estimate the number of
                                                                                           // calories
                                                                                           // your body needs at rest.
    } else if (gender.equals("female")) {
      calories = (int) ((4.33789 * weight) + (4.69798 * height) - (4.6756 * age) + 655.0955);
    } else {
      System.out.print("Invalid input, please try again.");
      System.exit(1); // Exit the program in case of invalid input
    }

    if (activityLevel == 1) { // Multiplies the user's basic metabolic rate by their activity level
      calories = (int) (calories * 1.2);
    } else if (activityLevel == 2) {
      calories = (int) (calories * 1.375);
    } else if (activityLevel == 3) {
      calories = (int) (calories * 1.55);
    } else if (activityLevel == 4) {
      calories = (int) (calories * 1.725);
    } else if (activityLevel == 5) {
      calories = (int) (calories * 1.9);
    }

    return calories;
  }

  public static int numCarbs(int parameter, int diet) {// This method takes the calculated calorie value and the user's
                                                       // selected diet plan as parameters. It calculates the
                                                       // recommended daily intake of carbohydrates based on the
                                                       // percentage associated with the chosen diet plan (20%, 40%, or
                                                       // 60%).
    int carbohydrates;
    double carbs = 0;
    if (diet == 1) {
      carbs = (double) parameter * 0.2 / 4; // 20%
    } else if (diet == 2) {
      carbs = (double) parameter * .4 / 4; // 40%
    } else if (diet == 3) {
      carbs = (double) parameter * .6 / 4; // 60%
    }
    carbohydrates = (int) carbs;
    return carbohydrates;// The calculated value is converted to an integer and returned.
  }

  public static int numFats(int parameter, int diet) {// This method calculates the recommended daily intake of fats
                                                      // based on the chosen diet plan's percentage (50%, 30%, or 15%).
    int fats;
    double fat = 0;
    if (diet == 1) {
      fat = (double) parameter * 0.5 / 9; // 50%
    } else if (diet == 2) {
      fat = (double) parameter * 0.3 / 9; // 30%
    } else if (diet == 3) {
      fat = (double) parameter * .15 / 9; // 15%
    }
    fats = (int) fat;
    return fats;
  }

  public static int numProtein(int parameter, int diet) {// This method calculates the recommended daily intake of
                                                         // protein based on the chosen diet plan's percentage (30%,
                                                         // 30%, or 25%).
    int protein;
    double proteins = 0;
    if (diet == 1) {
      proteins = (double) parameter * 0.3 / 4; // 30%
    } else if (diet == 2) {
      proteins = (double) parameter * 0.3 / 4; // 30%
    } else if (diet == 3) {
      proteins = (double) parameter * .25 / 4; // 15%
    }
    protein = (int) proteins;
    return protein;
  }

  public static void main(String[] args) {
    int calories = numCals();
    System.out.println("You should consume " + calories + " calories per day.");// calls the method numCals()
    System.out.println("Thank you, now lets organize a diet!");
    System.out.println("Please select a diet plan:");
    System.out.println("1 (Ketogenic diet)");
    System.out.println("2 (Balanced diet)");
    System.out.println("3 (High-carb diet)");
    Scanner scan = new Scanner(System.in);
    int diet = scan.nextInt();// stores the diet plan that the user chooses
    int carbohydrates = numCarbs(calories, diet);
    int fats = numFats(calories, diet);
    int protein = numProtein(calories, diet);
    System.out.println("Here is your finished diet plan:");
    System.out.println("You should consume " + calories + " calories per day.");
    System.out.println("You should have " + carbohydrates + " grams of carbohydrates per day.");
    System.out.println("You should have " + fats + " grams of fat per day.");
    System.out.println("You should have " + protein + " grams of protein per day.");
    System.out.println("Now it's time to go achieve your goals!");
  }
}