import { EventEmitter, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UiService {

  formChanged = new EventEmitter<boolean>();
  
  constructor() { }

  toggleForm(){
    this.formChanged.emit();
  }
}
