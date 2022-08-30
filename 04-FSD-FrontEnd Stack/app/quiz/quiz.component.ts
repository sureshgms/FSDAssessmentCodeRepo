import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Questions } from '../questions';
import { FormControl, FormGroup } from '@angular/forms';
import { IncompleteSubmitComponent } from '../incomplete-submit/incomplete-submit.component';
import {LocalStorageService, SessionStorageService} from 'ngx-webstorage';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {

  questions:Array<Questions>=[];
  selectedAnswers = new Map();
  completionObject = new IncompleteSubmitComponent();
  constructor(public http:HttpClient) { }

  quizsubmitRef = new FormGroup({
    email : new FormControl(),
    password : new FormControl()
  });

  ngOnInit(): void {
    this.http.get("/assets/questions.json").
    subscribe((result:any) =>this.questions=result.questions,error=>console.log(error),()=>console.log("completed"))
  }

  correctAns(qnumber:number, answer:string) {
    console.log("event fired...");
    console.log(qnumber+".."+answer);
    this.selectedAnswers.set(qnumber,answer);
    console.log(this.selectedAnswers);

  }

  quizSubmit() {
    
    sessionStorage = sessionStorage;
    this.selectedAnswers.forEach((value: string, key:string)  =>{
      console.log(key,value);
    })
    console.log(this.selectedAnswers.size);
    this.completionObject.completionmsg = "This should be working";

    sessionStorage.setItem("completionmsg","This is a test");
  }
}
