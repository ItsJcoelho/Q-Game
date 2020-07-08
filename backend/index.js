const express = require("express")
const bodyParser = require("body-parser")
const app = express()
const http = require("http").createServer(app)
require("dotenv").config()
const morgan = require("morgan")
const cors = require("cors")

const port = process.env.PORT || 3000

app.use(cors({ credentials: true, origin: true }))
app.use(bodyParser.json({ limit: "10000kb" }))
app.use(bodyParser.urlencoded({ extended: false }))


// using morgan to log requests to console
// https://github.com/expressjs/morgan
app.use(morgan(":method :url :status :response-time ms - :res[content-length] :date[web]"))


// imports all controllers
require("./app/routes")(app)

http.listen(port, "0.0.0.0", () => {
    console.log(`\n\n\nListening on port ${port}.\n\n\n`)
})