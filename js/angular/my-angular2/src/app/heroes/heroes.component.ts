import {Component, OnInit} from "@angular/core";
import {Hero} from "../hero/hero";
// import {HeroService} from "../hero/hero.service";
import {Router} from "@angular/router";
import {HeroService} from "../hero/hero.service";

@Component({
  moduleId: module.id,
  selector: 'my-heroes',
  templateUrl: "heroes.component.html",
  styleUrls: ["heroes.component.css"]
})
export class HeroesComponent implements OnInit {
  constructor(private router: Router,
              private heroService: HeroService
              //,        private location: Location
  ) {
  }

  // title = 'Tour of Heroes';
  //hero = 'Windstorm';
  selectedHero: Hero;
  heroes: Hero[];

  onSelect(hero: Hero): void {
    this.selectedHero = hero;
  }

  getHeroes(): void {
    this.heroService.getHeroes().then(heroes => this.heroes = heroes);
  }

  ngOnInit(): void {
    this.getHeroes();
  }

  gotoDetail(): void {
    this.router.navigate(['/detail', this.selectedHero.id]);
  }

  // save(): void {
  //     this.heroService.update(this.hero)
  //         .then(() => this.goBack());
  // }

  // goBack(): void {
  //     this.location.back();
  // }
  add(name: string): void {
    name = name.trim();
    if (!name) {
      return;
    }
    this.heroService.create(name)
      .then(hero => {
        this.heroes.push(hero);
        this.selectedHero = null;
      });
  }

  delete(hero: Hero): void {
    this.heroService
      .delete(hero.id)
      .then(() => {
        this.heroes = this.heroes.filter(h => h !== hero);
        if (this.selectedHero === hero) {
          this.selectedHero = null;
        }
      });
  }
}
