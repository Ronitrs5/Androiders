package com.example.androiders.model;

public class QuestionAnswer {

    public static String question[]=
            {
                    "Two or more radio buttons together is called as...", //r1
                    "Which of the following is not a valid type of EditText in Android Studio?", //e1
                    "Correct keyword to add clicks to buttons or views is...", //b1
                    "Which of the following are orientations of linear layout?", //l1
                    "How many direct children does a Scrollview have?",//s1
                    "What is the correct syntax to display a Toast in android?",//t1

                    "Correct tag to add checkbox in Android Studio is...\n(Case sensitive)",//r2
                    "Edit texts are used to...", //e2
                    "Basic and default type of progress bar in Android Studio is...",//b2
                    "Fill in the blanks:\n\nLinear layouts are best used when...",//l2
                    "There are ... types of scroll views by default in Android Studio",//s2
                    "How should the message in the toast be?",//t2

                    "Most of the visible elements in will be in which file?",
                    "Dependencies of libraries are in which files?",
                    "How can we travel from one activity to another?"

            };

    public static String choices[][]=
            {
                    {"Radio Cluster", "Radio Group", "Radio Class", "Radio Together"},
                    {"Phone", "Email", "TextView", "Password"},
                    {"setOnClickListener", "onClickResult", "clicked", "onClickListener"},
                    {"Vertical & Diagonal", "Vertical & Horizontal","Horizontal & Diagonal ", "All of the above"},
                    {"1", "2", "3", "4"},
                    {"Toast.show()", "Toast.display()", "Toast.start()", "Toast.visible()"},
                    {"<checkbox/>", "<CheckBox/>", "<Checkbox/>", "<checkBox/>"},
                    {"Display image", "Customize texts", "Add buttons", "Take user input"},
                    {"Circular", "Four dots", "Zig zag", "Oval"},
                    {"you dont know constraint layout", "stack elements on top", "you know linear layouts well", "linear layouts are always best"},
                    {"4","3","2","1"},
                    {"As detailed as possible", "As short as possible", "Minimum 5 lines", "Minimum 7 lines"},
                    {"Kotlin", "Java", "Android Manifest", "XML"},
                    {"build.gradle (Project level)", "build.gradle (Module level)", "gradle.properties (Project level)", "settings.gradle (Project settings)"},
                    {"Intents", "Handlers", "Activities", "Fragment Transactions"}
            };

    public static String correctAnswer[]=
            {
                    "Radio Group",
                    "TextView",
                    "setOnClickListener",
                    "Vertical & Horizontal",
                    "1",
                    "Toast.show()",
                    "<checkBox/>",
                    "Take user input",
                    "Circular",
                    "stack elements on top",
                    "2",
                    "As short as possible",
                    "XML",
                    "build.gradle (Module level)",
                    "Intents"


            };
}
