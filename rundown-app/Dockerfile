FROM node:12.4.0-alpine AS build

WORKDIR /app
COPY package.json package-lock.json ./
RUN npm install
COPY . ./
CMD [ "npm", "start" ]
RUN npm run build

FROM nginx:1.17.0-alpine
COPY --from=build /app/build /var/www
COPY ./nginx.conf /etc/nginx/nginx.conf
EXPOSE 80

ENTRYPOINT ["nginx","-g","daemon off;"]
