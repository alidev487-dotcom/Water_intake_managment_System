# AFFAN UMER - Main Program Flow

## File
- src/MainSystem.java

## Method
- main(String[] args)

## Task Explanation
- Controls the full menu flow of the program.
- Shows all menu options to the user.
- Reads the user choice and runs the correct action.
- Coordinates all other classes:
  - InputHandler for user input
  - User for profile data
  - WaterIntakeManager for water history
  - GoalCalculator for daily goal
  - HydrationEvaluator for status
  - SummaryDisplay for final summary
- Applies the max single-entry intake rule (5000 ml).
