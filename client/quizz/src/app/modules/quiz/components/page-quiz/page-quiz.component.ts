import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable} from 'rxjs';
import { Quiz } from 'src/app/interface/quiz';
import { QuizService } from '../../services/quiz.service';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Question } from 'src/app/interface/question';
import { Choice } from 'src/app/interface/choice';

@Component({
  selector: 'app-page-quiz',
  templateUrl: './page-quiz.component.html',
  styleUrls: ['./page-quiz.component.css']
})
export class PageQuizComponent implements OnInit {
  quiz$!: Observable<Quiz>;
  currentQuestionIndex: number = 0;
  quizForm!: FormGroup;
  isQuizCompleted: boolean = false;
  correctAnswers: number = 0;

  constructor(private quizService: QuizService, private route: ActivatedRoute, private formBuilder: FormBuilder){}

  ngOnInit(): void {
    this.quizForm = this.formBuilder.group({
      questions: this.formBuilder.array([]),
      results: ['']
    });
    this.getQuiz();
  }

  getQuiz() {
    const quizId = this.route.snapshot.paramMap.get('id');
      if(quizId != null){
        this.quiz$ = this.quizService.fetchQuiz(quizId);
        
        this.quiz$.subscribe(quiz => {
          quiz.questions?.forEach((question) => {
            this.questions.push(this.createQuestion(question));
            
          });
        });
        
      }
  }

  get questions() {
    return this.quizForm.get('questions') as FormArray;
  }

  createQuestion(question: Question): FormGroup {
    //const choicesArray = this.createChoices(question);
    let answers = question.answers.map(answer => answer.choice.content);
    console.log(question.choices);
    return this.formBuilder.group({
      content: question.content,
      choices: [question.choices],
      selectedChoices: [[], Validators.required],
      answers: [answers],
      isCorrect: false
    });

  
        
  }

  createChoices(question: Question): FormArray<FormGroup>{
    let choicesArray = new FormArray<FormGroup>([]);

    question.choices.forEach(choice => choicesArray.push(new FormGroup({
      id: new FormControl(choice.id),
      content: new FormControl(choice.content),
    })));

    return choicesArray;
  }

  submitQuiz(){
    if(this.currentQuestionIndex < this.questions.length - 1) {
      this.currentQuestionIndex += 1;
    } else {
      this.displayResults();
    }    
  }

  displayResults(){
    this.currentQuestionIndex = -1;
    this.isQuizCompleted = true;    
    const numberOfQuestions = this.quizForm.get('questions')?.value.length;

    this.questions.controls.forEach(question => {
      if(question.get('answers')?.value[0] == question.get('selectedChoices')?.value){
        this.correctAnswers +=1;
        question.get('isCorrect')?.setValue(true);
      }
    })

    this.quizForm.get('results')?.setValue(`${this.correctAnswers} / ${numberOfQuestions}`);  
  
  };  

}


