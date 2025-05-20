# Etapa 1 - Build da aplicação Angular
FROM node:18-alpine as builder

WORKDIR /app
COPY package*.json ./
RUN npm install

COPY . .
RUN npm run build --prod

# Etapa 2 - Servindo com NGINX
FROM nginx:alpine
COPY --from=builder /app/dist/frontend /usr/share/nginx/html

# (opcional) nginx.conf customizado
# COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
