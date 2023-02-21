<script setup lang="ts">
import { ref, reactive,onMounted } from "vue";
import createAgendamento from "../components/ModalInputAgendamento.vue";

import configAxios from "../axios/configAxios"

const columns = [
  {
    name: "name",
    required: true,
    label: "Cliente",
    align: "left",
    field: (row) => row.name,
    format: (val) => `${val}`,
    sortable: true,
  },
  {
    name: "servico",
    align: "center",
    label: "Serviço",
    field: "calories",
    sortable: true,
  },
  {
    name: "data",
    label: "Data ",
    field: "calcium",
    sortable: true,
    sort: (a, b) => parseInt(a, 10) - parseInt(b, 10),
  },
  {
    name: "hora",
    label: "Hora",
    field: "iron",
    sortable: true,
    sort: (a, b) => parseInt(a, 10) - parseInt(b, 10),
  },
  {
    name: "editar",
    label: "editar",
    field: "iron",
    sortable: true,
    sort: (a, b) => parseInt(a, 10) - parseInt(b, 10),
  },
  {
    name: "excluir",
    label: "Excluir",
    field: "iron",
    sortable: true,
    sort: (a, b) => parseInt(a, 10) - parseInt(b, 10),
  },
];

const rows = [
  {
    name: "Frozen Yogurt",
    calories: 159,
    fat: 6.0,
    carbs: 24,
    protein: 4.0,
    sodium: 87,
    calcium: "14%",
    iron: "1%",
  },
  {
    name: "Ice cream sandwich",
    calories: 237,
    fat: 9.0,
    carbs: 37,
    protein: 4.3,
    sodium: 129,
    calcium: "8%",
    iron: "1%",
  },
  {
    name: "Eclair",
    calories: 262,
    fat: 16.0,
    carbs: 23,
    protein: 6.0,
    sodium: 337,
    calcium: "6%",
    iron: "7%",
  },
  {
    name: "Cupcake",
    calories: 305,
    fat: 3.7,
    carbs: 67,
    protein: 4.3,
    sodium: 413,
    calcium: "3%",
    iron: "8%",
  },
  {
    name: "Gingerbread",
    calories: 356,
    fat: 16.0,
    carbs: 49,
    protein: 3.9,
    sodium: 327,
    calcium: "7%",
    iron: "16%",
  },
  {
    name: "Jelly bean",
    calories: 375,
    fat: 0.0,
    carbs: 94,
    protein: 0.0,
    sodium: 50,
    calcium: "0%",
    iron: "0%",
  },
  {
    name: "Lollipop",
    calories: 392,
    fat: 0.2,
    carbs: 98,
    protein: 0,
    sodium: 38,
    calcium: "0%",
    iron: "2%",
  },
  {
    name: "Honeycomb",
    calories: 408,
    fat: 3.2,
    carbs: 87,
    protein: 6.5,
    sodium: 562,
    calcium: "0%",
    iron: "45%",
  },
  {
    name: "Donut",
    calories: 452,
    fat: 25.0,
    carbs: 51,
    protein: 4.9,
    sodium: 326,
    calcium: "2%",
    iron: "22%",
  },
  {
    name: "KitKat",
    calories: 518,
    fat: 26.0,
    carbs: 65,
    protein: 7,
    sodium: 54,
    calcium: "12%",
    iron: "6%",
  },
];

async function axios () {
 const resul = await configAxios.get("/agendamento")
 console.log(resul.data)
}

const toolbar = ref(false);

onMounted(() => {
  axios()
})
</script>
<template>
  <div class="container">
    <div class="filho">
      <div>
        <q-table :rows="rows" :columns="columns" row-key="name" color="amber">
          <template v-slot:top>
            <h5>Lista de Agendamento</h5>
            <q-space />
            <q-btn
              class="btn"
              round
              color="positive"
              size="md"
              icon="add"
              @click="toolbar = true"
            />
          </template>
        </q-table>
      </div>
    </div>
    <div>
      <q-dialog  full-height v-model="toolbar">
        <q-card style="width: 1000px; max-width: 80vw;">
          <q-toolbar>
            <q-avatar>
              <img src="https://cdn.quasar.dev/logo-v2/svg/logo.svg" />
            </q-avatar>

            <q-toolbar-title
              ><span class="text-weight-bold">Agendamento</span>
              Insira os dados para um novo agendamento</q-toolbar-title
            >

            <q-btn flat round dense icon="close" v-close-popup />
          </q-toolbar>

          <q-card-section>
            <createAgendamento></createAgendamento>
          </q-card-section>
        </q-card>
      </q-dialog>
    </div>
  </div>
</template>
<style scoped>
.container {
  width: 100%;
  height: auto - 100px;
}

.filho {
  margin: 50px auto;
  width: 70%;
}
.filho div {
  margin-bottom: 20px;
}
</style>
