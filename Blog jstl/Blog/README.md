Создать заготовку для блога. Взять шаблоны главной страницы 
https://github.com/BlackrockDigital/startbootstrap-blog-home
и отдельного поста https://github.com/BlackrockDigital/startbootstrap-blog-post

Реализовать админ панель в которой можно реализовать:
1. Добавлине поста
2. Редактирование постов
3. Удаление постов

Реализовать хранение аутентифицированного пользователя в сессии.
Ограничение доступа к ресурсам организовать через фильтры


1. Все посты: class MainServlet, index.jsp.
2. Добавить пост: сверху кнопка Add new post (class AddPostServlet, add.jsp).
   При добавлении поста контент разделен на 5 частей(заполнять можно любой) для отображения на странице по абзацам.
3. Посмотреть конкретный пост: в каждом посте кнопка Read more (class PostServlet, post.jsp).
4. Добавить коммент: в каждом посте внизу кнопка Submit (class AddCommit, post.jsp).
5. Поиск по категориям поста: справа панель Categories (class CategoryServlet, sidebar.jsp).
6. Поиск по названию поста: справа панель Search (class SearchServlet, sidebar.jsp).
7. Регистрация нового пользователя (сlass RegistrationServlet, registration.jsp).
8. Авторизация зарегистрированного пользователя (сlass HomeServlet, authorization.jsp).
9. Logout (class LogoutServlet, post/template/head.jsp).
10. Редактирование/удаление поста: при открытии конкретного поста (кнопка Read more), сверху иконки edit and trash.
(post.jsp, classes EditPostServlet/DeletePostServlet).
11. Количество пользователей на сайте: class SessionListener, post/template/head.jsp.