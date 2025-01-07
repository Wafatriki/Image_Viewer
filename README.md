# ImageViewer

ImageViewer es una aplicación Java diseñada para visualizar imágenes de manera eficiente y fácil de usar. Permite a los usuarios navegar entre imágenes utilizando botones de siguiente y anterior, y está optimizada para un rendimiento rápido y fluido.


<p align="center">
  <img images/pexels-apasaric-1285625.jpg" alt="pexels-apasaric-1285625" width="200"/>
  <img images/pexels-baskincreativeco-1576667.jpg" alt="pexels-baskincreativeco-1576667" width="200"/>
  <img images/pexels-casia-charlie-1270232-2433467.jpg" alt="pexels-casia-charlie-1270232-2433467" width="200"/>
  <img images/pexels-nout-gons-80280-248159.jpg" alt="pexels-nout-gons-80280-248159" width="200"/>
  <img images/pexels-pixabay-206359.jpg" alt="pexels-pixabay-206359" width="200"/>
  <img images/pexels-souvenirpixels-1486974.jpg" alt="pexels-souvenirpixels-1486974" width="200"/>
  <img images/pexels-souvenirpixels-1619317.jpg" alt="pexels-souvenirpixels-1619317" width="200"/>
  <img images/pexels-valentin-cvetanoski-2147958923-30107968.jpg" alt="pexels-valentin-cvetanoski-2147958923-30107968" width="200"/>
  <img images/pexels-wojtekstrzelec-1595742.jpg" alt="pexels-wojtekstrzelec-1595742" width="200"/>
</p>

## Características

- **Navegación de Imágenes**: Permite a los usuarios navegar entre imágenes utilizando botones de siguiente (`>`) y anterior (`<`).
- **Optimización de Rendimiento**: Utiliza `SwingWorker` para cargar imágenes en segundo plano y un caché de imágenes para mejorar el rendimiento.
- **Interfaz de Usuario Intuitiva**: Interfaz de usuario sencilla y fácil de usar.
- **Soporte para Múltiples Formatos de Imagen**: Compatible con formatos de imagen comunes como `.jpg`, `.png` y `.gif`.

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes:

- `control`: Contiene las clases relacionadas con los comandos.
  - `Command.java`
  - `CommandManager.java`
  - `NextImageCommand.java`
  - `PrevImageCommand.java`

- `model`: Contiene las clases relacionadas con el modelo de datos.
  - `Image.java`

- `view`: Contiene las clases relacionadas con la visualización.
  - `ImageDisplay.java`
  - `ImageReader.java`
  - `ImageDisplayPanel.java`
  - `MainFrame.java`

- `service`: Contiene las clases relacionadas con la lógica de negocio o servicios.
  - `ImageFileReader.java`
  
- `Main.java`