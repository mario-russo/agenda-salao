<script setup lang="ts">
import { ref } from 'vue';
import routes from './router/routes'

const leftDrawerOpen = ref(true)
function toggleLeftDrawer() {
  leftDrawerOpen.value = !leftDrawerOpen.value
}
</script>
<template>
  <q-layout view="hHh lpR fFf">

    <q-btn class="btn" @click="toggleLeftDrawer" round color="secondary" size="lg" icon="menu" />
    <q-drawer show-if-above v-model="leftDrawerOpen" side="left" bordered>
      <q-item v-for="link in routes" :key="link.name" v-ripple clickable :to="link.path">
        <q-item-section avatar>
          <q-icon color="grey" :name="link.icon" />
        </q-item-section>
        <q-item-section>
          <q-item-label>{{ link.name }}</q-item-label>
        </q-item-section>
      </q-item>
    </q-drawer>

    <q-page-container class="container">
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<style scoped>
.container {
  margin: 0;
  display: flex;
  flex-direction: column;
  place-items: center;
  min-height: 100vh;
}

.btn {
  position: absolute;
  top: 20px;
  right: 10%;
}
</style>
