import 'package:flutter/material.dart';
import 'package:quiz_app/question.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Quiz App',
      home: QuizScreen(),
    );
  }
}

class QuizScreen extends StatefulWidget {
  const QuizScreen({Key? key}) : super(key: key);

  @override
  _QuizScreenState createState() => _QuizScreenState();
}

class _QuizScreenState extends State<QuizScreen> {
  List<Question> questionBank=[
    Question("Question 1", true),
    Question("Question 2", false),
    Question("Question 3", true),
    Question("Question 4", true),
    Question("Question 5", false),
    Question("Question 6", false),
  ];
  int ques_num=0;
  int score=0;

    void action(bool answer){
     if(answer==questionBank[ques_num].answer){
       setState(() {
         score++;
       });
     }
     if(ques_num<questionBank.length-1){
       setState(() {
         print(ques_num);
         ques_num++;
       });
     }
     else{
       Navigator.push(
         context,
         MaterialPageRoute(
           builder: (context) => FinalScreen(score:score)
         ),
       );
     }
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Quiz App"),),
      body: Column(
        children: [
          Query(),
          Options(),
          Score()
        ],
      ),
    );
  }
  Widget Query() {
      return Center(
        child: Text(
            questionBank[ques_num].questionText,
          style: TextStyle(fontSize: 30, fontWeight: FontWeight.bold),
        ),
      );
  }

  Widget Options(){
    return Column(
      children: [
        Center(
          child: TextButton(
            onPressed: () => action(true),
            child: Text(
                "True",
              style: TextStyle(fontWeight: FontWeight.bold, fontSize: 20, color: Colors.pink),
            ),
          ),
        ),
        Center(
          child: TextButton(
            onPressed: () => action(false),
            child: Text(
                "False",
              style: TextStyle(fontWeight: FontWeight.bold, fontSize: 20, color: Colors.pink),
            ),
          ),
        )
      ],
    );
  }

  Widget Score(){
      return Column(
        children: [
          Center(
            child: Text(
                "Current Score",
              style: TextStyle(fontWeight: FontWeight.bold, fontSize: 25, color: Colors.green),
            ),
          ),
          Center(
            child: Text(
                "$score",
              style: TextStyle(fontWeight: FontWeight.bold, fontSize: 25, color: Colors.black),
            ),
          ),
        ],
      );
  }
}


class FinalScreen extends StatefulWidget {
  final int score;
  const FinalScreen({Key? key, required this.score}) : super(key: key, );

  @override
  _FinalScreenState createState() => _FinalScreenState(score:score);
}

class _FinalScreenState extends State<FinalScreen> {
  final int score;
_FinalScreenState ({Key? key, required this.score});

  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.white,
      child: Padding(
        padding: const EdgeInsets.only(left: 20.0, top: 300.0, right: 20.0, bottom: 60.0),
          child: Column(
            children: [
              Center(
                child: Text(
                    "Final Score",
                  style: TextStyle(color: Colors.blueAccent, decoration: TextDecoration.none),
                ),
              ),
              Center(
                child: Text(
                    "$score",
                  style: TextStyle(color: Colors.blueAccent, decoration: TextDecoration.none),
              ),
              ),
            ],
          ),
      ),
    );
  }
}


