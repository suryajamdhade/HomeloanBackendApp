import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CMModule } from './cm/cm.module';
import { REModule } from './re/re.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    REModule,
    HttpClientModule,
    FormsModule,
    CMModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
