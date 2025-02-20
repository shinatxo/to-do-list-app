import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';

export default defineConfig({
  base: '/',
  plugins: [react()],
});

const apiUrl = import.meta.env.VITE_API_URL;
fetch(`${apiUrl}/your-endpoint`)
  .then(response => response.json())
  .then(data => console.log(data));
