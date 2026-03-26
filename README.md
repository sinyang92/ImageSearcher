# Sample Flickr Image Search App

Android application built with Jetpack Compose with modularisation approach.

## Architecture
The project applies modularisation and CLEAN architecture.

### Modules Overview
*   **`:app`**  
    Contains application class, MainActivity, and Compose Navigation.
*   **`:feature`**  
    Contains the actual features. Currently it has only one feature which is searching images.
*   **`:common`**  
    Act as a shared library module to provide utilities such as Networking and resource handling. It can be used by other modules.
*   **`:design`**  
    Contains common UI components that can be reused. e.g. Button, Column with padding, etc.

## Build & Run

### 1. Prerequisites
- Android Studio Ladybug or newer.
- Gradle 8.0+.

### 2. Flickr API Key Setup
For security reason the Flickr API key is managed by **Secrets Gradle Plugin** and is not committed to version control.
To build and run the app a valid Flickr API key needs to be add to the `local.properties` file in the projects' root directory:
```
IMAGE_API_KEY=flickr_api_key
```

## Test Coverage
| Package | Class % | Method % | Branch % | Line % |
| :--- | :--- | :--- | :--- | :--- |
| com.sinyang92.common | 0% (0/1) | 0% (0/2) | - | 0% (0/2) |
| com.sinyang92.common.network.data.di | 0% (0/2) | 0% (0/8) | - | 0% (0/16) |
| com.sinyang92.common.network.data.impl | 100% (3/3) | 100% (6/6) | 75% (3/4) | 100% (15/15) |
| com.sinyang92.common.network.domain.model | 100% (4/4) | 100% (4/4) | - | 100% (4/4) |
| com.sinyang92.design.component | 0% (0/6) | 0% (0/10) | 0% (0/10) | 0% (0/51) |
| com.sinyang92.design.theme | 0% (0/3) | 0% (0/10) | 0% (0/14) | 0% (0/34) |
| com.sinyang92.feature.searchimage.data.di | 0% (0/1) | 0% (0/2) | - | 0% (0/2) |
| com.sinyang92.feature.searchimage.data.dto | 100% (3/3) | 100% (3/3) | - | 100% (9/9) |
| com.sinyang92.feature.searchimage.data.repositoryimpl | 100% (2/2) | 100% (3/3) | - | 100% (6/6) |
| com.sinyang92.feature.searchimage.data.service | 100% (1/1) | 100% (1/1) | - | 100% (4/4) |
| com.sinyang92.feature.searchimage.domain.usecase | 100% (1/1) | 100% (2/2) | - | 100% (3/3) |
| com.sinyang92.feature.searchimage.ui.model | 100% (5/5) | 100% (5/5) | - | 100% (8/8) |
| com.sinyang92.feature.searchimage.ui.resultscreen | 20% (3/15) | 18.2% (4/22) | 18.2% (4/22) | 36.1% (26/72) |
| com.sinyang92.feature.searchimage.ui.searchscreen | 0% (0/3) | 0% (0/8) | 0% (0/6) | 0% (0/26) |
| com.sinyang92.imagesearcher | 0% (0/4) | 0% (0/16) | 0% (0/10) | 0% (0/34) |
* Core business logic is 100% covered. UI tests are TODO.
