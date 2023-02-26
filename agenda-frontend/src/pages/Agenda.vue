<script setup lang="ts">
import { ref, reactive, onMounted } from "vue";
import inputAgendamento from "../components/ModalInputAgendamento.vue";
import { Agendamento } from "../domain/Agendamento"
import{listAllAgendamento}from "../axios/services/AgendamentoService"

import { QTableProps, QTabPanelProps, useQuasar } from "quasar";
const quasar = useQuasar()

const columns: QTableProps["columns"] = [
  {
    name: "cliente",
    required: true,
    label: "Cliente",
    align: "left",
    field: "cliente",

  },
  {
    name: "servico",
    align: "center",
    label: "Serviço",
    field: "servico",

  },
  {
    name: "data",
    label: "Data ",
    field: "data",

  },
  {
    name: "hora",
    label: "Hora",
    field: "hora",

  },
  {
    name: "actions",
    label: "Ações",
    field: "actions",
    align:"right"

  },
 
];

const rows = ref<Agendamento[]>([]);

async function getAllAgendamento() {
  try {
    quasar.loading.show()
    const resul = await listAllAgendamento()
    rows.value = resul
    quasar.loading.hide()
  } catch (error) {
    ErroLoading()
  }
}
function ErroLoading() {
  quasar.notify({
    message: "Não foi possivel conectar com Sistema!!!",
    multiLine: true,
    type: 'negative'
  })
  quasar.loading.hide()
}
function loadingAgendamento() {
  toolbar.value = false
  getAllAgendamento()
}
const toolbar = ref(false);

onMounted(() => {
  getAllAgendamento()
})
</script>
<template>
      <div>
        <q-table :rows="rows" :columns="columns" row-key="name" color="amber">
          <template v-slot:top>
            <h5>Lista de Agendamento</h5>
            <q-space />
            <q-btn class="btn" round color="positive" size="md" icon="add" @click="toolbar = true" />
          </template>
          <template v-slot:body-cell="props">
            <q-td :props="props">
              <q-btn icon="remove" :dense="true" />
            </q-td>
          </template>
        </q-table>
      </div>
   
      <q-dialog full-height v-model="toolbar">
        <q-card style="width: 1000px; max-width: 80vw;">
          <q-toolbar>
            <q-avatar>
              <img src="https://cdn.quasar.dev/logo-v2/svg/logo.svg" />
            </q-avatar>

            <q-toolbar-title><span class="text-weight-bold">Agendamento</span>
              Insira os dados para um novo agendamento</q-toolbar-title>

            <q-btn flat round dense icon="close" v-close-popup />
          </q-toolbar>

          <q-card-section>
            <inputAgendamento @create-agendamento="loadingAgendamento()"></inputAgendamento>
          </q-card-section>
        </q-card>
      </q-dialog>
   
</template>
<style scoped>
div {
  margin-bottom: 20px;
}
</style>
