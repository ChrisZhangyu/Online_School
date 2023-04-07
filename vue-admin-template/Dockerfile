FROM node:10-alpine as builder




FROM nginx
ARG APP_BASE_URL

COPY docker/dist /usr/share/nginx/html/
