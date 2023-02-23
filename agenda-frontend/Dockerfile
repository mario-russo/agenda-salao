FROM node:lts-alpine as builder

WORKDIR /app

COPY package.json .
COPY package-lock.json .

RUN npm install
RUN npm install -g serve
# Bundle app source
COPY . ./

RUN chown -R node:node /app/node_modules

# start app
CMD ["npm", "run", "build"]


FROM nginx:1.15.2-alpine

COPY --from=builder /app/dist /var/www
COPY nginx.conf /etc/nginx/nginx.conf

EXPOSE 3000

ENTRYPOINT ["nginx","-g","daemon off;"]
