import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { Questions } from './questions';
import { QuizComponent } from './quiz/quiz.component';
import { IncompleteSubmitComponent } from './incomplete-submit/incomplete-submit.component';
import { CompleteSubmitComponent } from './complete-submit/complete-submit.component';
import {NgxWebstorageModule} from 'ngx-webstorage';



@NgModule({
  declarations: [
    AppComponent,
    QuizComponent,
    IncompleteSubmitComponent,
    CompleteSubmitComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})




export class AppModule { 
  
}
