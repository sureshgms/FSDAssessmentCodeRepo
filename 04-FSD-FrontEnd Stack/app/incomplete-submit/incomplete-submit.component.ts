import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-incomplete-submit',
  templateUrl: './incomplete-submit.component.html',
  styleUrls: ['./incomplete-submit.component.css']
})
export class IncompleteSubmitComponent implements OnInit {

  constructor() { }

  completionmsg:string = "Please select all answers";
  public sessionStorage = sessionStorage;

  ngOnInit(): void {
  }

}

 
