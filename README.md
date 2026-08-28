# Transcript Summarizer

A Spring Boot REST API for generating concise summaries from raw text or publicly accessible webpages. The application uses JSoup to extract webpage content and communicates with a locally hosted Llama 3.1 model through Ollama for summarization.

## Features

* **Text Summarization** — Accepts user-provided text and generates a concise summary.
* **URL Summarization** — Fetches and extracts readable webpage content using JSoup before sending it for summarization.
* **Local AI Inference** — Uses Ollama with Llama 3.1 instead of a third-party hosted AI API.
* **Summary Length Control** — Supports an optional maximum word count for generated summaries.
* **Error Handling** — Handles invalid requests, URL-fetch failures, unavailable Ollama services, and missing responses.
* **REST API** — Provides health-check and summarization endpoints through Spring Boot.

## Architecture

The application separates responsibilities across:

* **Controllers** — Handle HTTP requests and responses.
* **Services** — Contain summarization and external-service logic.
* **DTOs** — Represent request and response data exchanged between components.

## Tech Stack

Java 21 · Spring Boot · Maven · REST API · Ollama · Llama 3.1 · JSoup
