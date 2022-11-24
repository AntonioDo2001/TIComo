import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
@Injectable()
export class HelperValoracion {
  private message = new BehaviorSubject<String|undefined>('');
  public customMessage = this.message.asObservable();
  constructor() {}
  public changeMessage(msg: String|undefined): void {
    this.message.next(msg);
  }
}