# Stone Scissors Paper Backend

Backend for a stone, scissor and paper game. This backend has one endpoint to play the game. For this game you can use [this application](https://github.com/padigru/stone-scissor-paper-frontend) as frontend.

If you run the backend locally, you can access the Api-Documentation with http://localhost:8080/swagger-ui/index.html

## Build the application as docker image

To build the application as docker container run the following command in the root directory:

`docker build -t stone-scissors-paper-backend .`

Start the application with:

`docker run -it -p 8080:8080 stone-scissors-paper-backend`

## Run frontend and backend together

You can use the docker-compose file or the helm charts in [this repository](https://github.com/padigru/stone-scissor-paper-deployment).