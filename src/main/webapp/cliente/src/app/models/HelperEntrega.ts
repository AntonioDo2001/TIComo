import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
@Injectable()
export class HelperService {
  private message = new BehaviorSubject<string>('');
  public customMessage = this.message.asObservable();
  constructor() {}
  public changeMessage(idPlato: string): void {
    this.message.next(idPlato);
  }
}