<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<label for="inputEmail" class="sr-only">Email address</label>
<input name="email" type="email" id="inputEmail" class="form-control" maxlength="30" placeholder="Email address"
       pattern="[^А-Яа-я\s]+" title="only latin letters, numbers, symbols" required autofocus>

<label for="inputPassword" class="sr-only">Password</label>
<input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password"
       pattern="[^А-Яа-я\s]+" title="only latin letters, numbers, symbols" maxlength="20" required>

<div class="checkbox mb-3">
    <label>
        <input type="checkbox" value="remember-me"> Remember me
    </label>
</div>