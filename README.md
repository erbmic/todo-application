[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]

# ToDo Webapplication

## Inhaltsverzeichnis

* [Allgemein](#allgemein)
* [Desing](#design)
  * [Domänenmodell](#domnenmodell)
  * [Page flow](#page-flow)
  * [Klassendesign](#klassendesign)
* [Implementierung](#implementierung)
  * [Frontend](#frontend)
  * [Backend](#backend)
  * [REST-API](#backend)
  * [Zusätzliche Features](#zustzliche-features)
* [Verwendung](#verwendung)
  * [Voraussetzungen](#voraussetzungen)
* [Installation](#installation)

## Allgemein

## Design

### Domänenmodell

![Domänenmodell](.images/ApplicationModel_v02.drawio.png)

### Page Flow

### Klassendesign

## Implementierung

### Frontend

### Backend

Das Backend kann in die folgenden drei Breiche unterteilt werden.

- Model
- Web Controller
- REST Controller

#### Model
###### Account
Das Model baut auf dem Singleton `Account` auf. Dieses verwaltet die User und die Persistenz.
Nebst den notwendigen Methoden für das Anlegen und Anmelden der User, wurde eine Methode für das Löschen der User vorbereitet, 
so wie Methoden für das Validieren von Credentials bei neuen Anmeldungen erstellt.

Die `Valiedierungs-Methoden` können nach Belieben erweitert werden, um z.B. beim Anlegen eines Passworts gewisse Mindestanforderungen zu prüfen
(aktuell wird nur auf ein nicht leeren String geprüft).

Bei der `Persistenz` gab es immer wieder einige Schwierigkeiten und Tücken, welche mehr Zeit und Augenmerk verlangten als zu Beginn angenommen wurde.
- Das Marshalling von Map's
- Fehlende Getter und/oder Setter
- Marshalling von static field's

###### User
Jeder User hat aktuell eine `TodoList`, welche alle seine ToDo's, so wie eine Liste mit den Kategorien beinhaltet.
Ein User könnte dem entsprechend mehrere, unterschiedliche Listen und pro Liste unterschiedliche Kategorien  verwalten (aktuell nicht implementiert).

###### TodoList
Die TodoList verwaltet alle ToDo's.
Hier werden alle CRUD so wie Filter und Sortier Operationen auf die ToDO's gehandelt.
Zudem wird hier die ID für neu Erstellte ToDo's generiert und verteilt.

Eine Spezialität hier ist die `FilteredList`, welche bei einer Anfrage zum Filtern nach einer bestimmen Kategorie abgefüllt wird.

###### CatList
Die Klasse CatList wurde vorgesehen für das Anlegen und Verwalten eigener Kategorien.
Aktuell beinhaltet diese fünf vordefinierte Werte.

###### TodoProcessor
Der TodoProcessor ist eine `Utility Klasse` zur Prozessierung von Eingehenden Daten vom Web und vom REST in neue ToDo Instanzen.
Hier wird z.B. ein Datum in String vom in ein LocalDate umgewandelt.

#### Web Controller
Die eingehenden Request's werden von vier Servlet's gehandelt.
Die Post's werden jeweils mit Hilfe von einem Switch Case ausgeführt.

Ungültige Request's werden jeweils mit `Exceptions` gehandelt. 

#### REST Controller
Analog zum Web Controller werden hier drei Servlets zum Handling der Requests verwendet.
Auch hier werden ungültige Requests durch Exceptions gehandelt.

### REST-API

### Zusätzliche Features

## Verwendung

### Voraussetzungen


### Installation

1. Get a free API Key at [https://example.com](https://example.com)
2. Clone the repo
```sh
git clone https://github.com/your_username_/Project-Name.git
```
3. Install NPM packages
```sh
npm install
```
4. Enter your API in `config.js`
```JS
const API_KEY = 'ENTER YOUR API';
```


<!-- MARKDOWN LINKS & IMAGES -->
[domaenenmodell]: .images/ApplicationModel_v02.drawio.png
