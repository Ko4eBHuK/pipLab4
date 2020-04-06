import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import {RouterModule} from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { HelloCardComponent } from './hello-card/hello-card.component';
import { WorkZoneComponent } from './work-zone/work-zone.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    HelloCardComponent,
    WorkZoneComponent
  ],
    imports: [
        BrowserModule,
        ReactiveFormsModule,
        HttpClientModule,
        RouterModule.forRoot([
            {path: '', component: HelloCardComponent, pathMatch: 'full'},
            {path: 'login', component: LoginComponent},
            {path: 'work-zone-bruh', component: WorkZoneComponent}
        ])
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
