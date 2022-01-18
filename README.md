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

Dieses Repository enthält eine ToDo Webapplikation die im Kontext eines CAS (Certificate of Advanced Studies) der Berner Fachhochschule implementiert wurde.
Mit der ToDo App können ToDos pro User erstellt, editiert und gelöscht werden. 

Ein ToDo kann die folgenden Attribute enthalten:
- Titel
- Kategorie
- Wichtig (Boolean)
- Fälligkeitsdatum

In der Applikation ist ein 

## Design

### Domänenmodell

![Domänenmodell](.images/ApplicationModel_v02.drawio.png)

### Page Flow

### Klassendesign

## Implementierung

### Frontend

Ein erster Entwurf für das Frontend wurde in der Applikation `Figma` entworfen. Dafür wurden jeweils 4 Views für Mobile und Desktop entworfen - Login-, Register-, TodoEdit- und TodoList-View.
Generell wurde über das ganze Frontend 2 Fonts geladen, `Roboto` als allgemeine Font und `Font-Awesome` für Icons.

#### Login-, Register-View
Login und Register sind mit Formularen gelöst, die jeweils durch ein Button submittet werden. Fehlermeldungen werden jeweils rot eingeblendet.

#### List-View





### Backend

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
