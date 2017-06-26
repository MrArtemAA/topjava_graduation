# Выпуская работа в рамках онлайн проекта <a href="https://github.com/JavaOPs/topjava">Topjava</a>
## Постановка задачи
Спроектировать и реализовать REST API, используя Hibernate/Spring/SpringMVC (или Spring-Boot) **без пользовательского интерфейса**.

Задача:

Создать систему голосования для выбора куда сходить на обед.
* 2 типа пользователей: Администраторы (Админы, admin) или обычные пользователи
* Админ может добавлять рестораны и их меню на день (обычно 2-5 позиции, название блюда и цену)
* Меню меняется каждый день (Админы вносят все изменения)
* Пользователи могут голосовать за то, в какой рестора пойти обедать
* Голос учитывается только 1 раз
* Если пользователь голосует повторно в этот день, то:
  - Если это произошло до 11:00, считаем, что он изменил свое решение
  - Если после 11:00 - слишком поздно и изменение не может быть принято
  
 Ресторан предоставляет новое меню каждый день.
 
 В качестве результата, предоставьте ссылку на GitHub репозиторий. Он должен содержать код, README.md с документацией по API и примерами curl команд для тестирования.

## Документация
### Описание API
#### Сущности
* Пользователь (**User**): id, name, email, password, enabled, registered, roles; **UserTo**: id, name, email, password
* Ресторан (**Restaurant**): id, name; dishes
* Блюдо ресторана (**Dish**): id, name, date, price; **DishTo**: id, name, price

**Формат описания запроса**: <Тип_запроса> <URI> [Параметры_запроса] [(Тело_запроса)] [: <Данные_ответа>]
Для всех запросов, кроме регистрации необходима авторизация. Поддерживается базовая авторизация: email, password

### Для пользователей
* Регистрация: Post /api/register (UserTo): User
* Данные о пользователе: Get /api/profile : UserTo
* Изменить данные: Put /api/profile (UserTo)
* Удалить данные: Delete /api/profile
* Список ресторанов: Get /api/restaurants ?withDishes (default=true) : список Restaurant
* Данные о ресторане: Get /api/restaurants/id ?withDishes (default=true): Restaurant
* Все блюда ресторана: Get /api/restaurant/id/dishes: список Dish
* Проголосовать: Post /api/restaurant/id/vote

### Для администратора
#### Работа с пользователями
Список: Get /api/admin/users: список User
Данные об одном: Get /api/admin/users/id: User
Создать: Post /api/admin/users (UserTo): User
Изменить: Put /api/admin/users/id (UserTo)
Удалить: Delete /api/admin/users/id

#### Работа с ресторанами
Список: Get /api/admin/restaurants: список Restaurant
Данные об одном: Get /api/admin/restaurants/id: Restaurant
Создать: Post /api/admin/restaurants (Restaurant): Restaurant
Изменить: Put /api/admin/restaurants/id (Restaurant)
Удалить: Delete /api/admin/restaurants/id

#### Работа с меню ресторана
Список: Get /api/admin/restaurants/restaurantId/dishes: список Dish
Данные об одном блюде: Get /api/admin/restaurants/restaurantId/dishes/id: Dish
Создать: Post /api/admin/restaurants/restaurantId/dishes (DishTo): Dish
Изменить: Put /api/admin/restaurants/restaurantId/dishes/id (DishTo)
Удалить: Delete /api/admin/restaurants/restaurantId/dishes/id

### Примеры команд

## Используемые инструменты и технологии
Maven
Java 8
Spring (Data JPA, MVC, Security, Test, Security test)
Hibernate
SLF4J, Logback
HSQLDB
JUnit
Json (Jackson)
EhCache
jsoup
