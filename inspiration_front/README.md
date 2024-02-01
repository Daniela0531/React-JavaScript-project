# Inspiration
Сайт для писателей и читателей фентези.
Функционал:

    искать рассказы
    читать рассказы
    писать эпизоды
    объединять эпизоды в главу
    устанавливать картинку фона для эпизода

Основная главная страница, на которую можно попасть без регистрации, это **main-reader-page**.  
На ней вываливаются рекомендуемые истории (пока планируется, что будут вываливаться просто все подряд),  
есть поиск по названиям (возможно будет сложнее, если хватит времени).

## Функционал

все **inputs** умеют обрабатывать **Enter** и сохранять значение поля, используя **useState** и **key**
**TODO**: не умеет переключать состояние в зависимости от нажатия **Enter** (например переключать страницу)

### main-reader-page  

**Плашки с названием историй Story**   
Есть scroll поля с плашками.
При нажатии на плашку с нужной историей пользователь поподает на страницу чтения рассказа **read-page**.

**Кнопка Writer mode**  
Кнопка становится не прозрачной при наведении курсора на неё.  
Если ты зарегестрированный пользователь (проверки пока нет, это будет в бэке), то по кнопке **Write mode**  
можно попасть на главную страницу писателя **main-writer-page**.

**Поиск по историям Search**

добавлен

![img-readme/main-reader.jpeg](img-readme/main-reader.jpeg)

### read-page
(можно считать законченным)

**Кнопка Back to stories**  
Кнопка становится не прозрачной при наведении курсора на неё.  
При нажатии на неё пользователь возвращается обратно на **main-reader-page**.

**Плашка с названием истории StoryName**

**Плашка с номером главы ChapterNum**  

**Плашка с текстом истории ReadPanel**  
Есть scroll текста

![img-readme/read.jpeg](img-readme/read.jpeg)

### main-writer-page
(в доработке)

**Кнопка Reader mode**  
Кнопка становится не прозрачной при наведении курсора на неё.  
При нажатии на неё пользователь поподает на главную страницу читателя **main-reader-page**.

**Плашки с названием историй Story**   
Есть scroll поля с плашками.
При нажатии на плашку с нужной историей пользователь поподает на страницу написания рассказа **write-page**.

**Есть два режима: уже написаннные истории и истории, которые ещё не окончены**

![img-readme/main-writer.jpeg](img-readme/main-writer.jpeg)

### write-page

**Кнопка Back to stories**  
Кнопка становится не прозрачной при наведении курсора на неё.  
При нажатии на неё пользователь возвращается обратно на **main-writer-page**.

**Плашка с названием истории StoryName**

**Плашка с номером главы ChapterNum**

**Плашка с номером эпизода Episode**

**Кнопка загрузки картинки LoadPicture**

**Плашка = поле для ввода текста истории**  

![img-readme/write.jpeg](img-readme/write.jpeg)

### authorization logic

**Общая логика:**

    Authorization ---**To register**---> Registration ---**Back**---> Authorization

                                         Registration ---зарегался---> Authorization

    Authorization ---**forgot name**---> Password ---**Back**---> Authorization
                                         Password ---**ввёл**---> GetCode ---**Back**---> Password
                                                                  GetCode ---ввёл---> SetNewName ---**Back**---> GetCode
                                                                                      SetNewName ---ввёл---> Authorization
    
    Authorization ---**forgot password**---> Name ---**Back**---> Authorization
                                             Name ---**ввёл**---> GetCode ---**Back**---> Name
                                                                  GetCode ---ввёл---> SetNewPassword ---**Back**---> GetCode
                                                                                      SetNewPassword ---ввёл---> Authorization

    
    Authorization ---ввёл все поля---> WriterPage

**TODO**: переключать страницы по нажатию **Enter**

### authorization-page

![img-readme/authorization.jpeg](img-readme/authorization.jpeg)

### registration-page

![img-readme/registration.jpeg](img-readme/registration.jpeg)

### name-restoration-page

![img-readme/name-restoration.jpeg](img-readme/name-restoration.jpeg)

### password-restoration-page

![img-readme/password-restoration.jpeg](img-readme/password-restoration.jpeg)

### code-page

![img-readme/code.jpeg](img-readme/code.jpeg)

### new-password-page

![img-readme/new-password.jpeg](img-readme/new-password.jpeg)

### new-name-page

![img-readme/new-name.jpeg](img-readme/new-name.jpeg)
