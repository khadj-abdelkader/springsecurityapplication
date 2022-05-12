# springsecurityapplication

## 
- Aller sur GitHub
- Aller dans les Settings
- Aller dans Developer Settings
- Cliquer sur new OAuth App
- Renseigner le nom de l'application, son url (http://localhost:8080) et son authorization callbackurl URL (http://localhost:8080/login/oauth2/code/github)
- Cliquer sur "Generate a new client secret"
- Confirmer par le mot de passe de GitHub
- Copier-coller le client secret dans applications.properties ligne 2 à la place de ```<secret>```
- Copier-coller le client ID dans application.properties ligne 1 à la place de ```<client-id>```
- (Ne pas laisser les <> autour)
- Tout est bon, vous pouvez tester l'appli ! 