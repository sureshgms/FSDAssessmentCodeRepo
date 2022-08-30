import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CompleteSubmitComponent } from './complete-submit/complete-submit.component';
import { IncompleteSubmitComponent } from './incomplete-submit/incomplete-submit.component';

import { QuizComponent } from './quiz/quiz.component';

const routes: Routes = [
  {path:"quizcomponent",component:QuizComponent},
  {path:"incompletesubmit", component:IncompleteSubmitComponent},
  {path:"completesubmit", component:CompleteSubmitComponent}
 ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
