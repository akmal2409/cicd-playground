import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'frontend';
  health!: any;

  constructor(
    private readonly http: HttpClient
  ) {
    this.pollHealth();
  }

  public pollHealth() {
    this.http.get('https://bn01.viaware.nl/api/health')
      .subscribe(health => {
        this.health = health;
      });
  }
}
