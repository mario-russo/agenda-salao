<script setup lang="ts">
import { ref, reactive, onMounted } from "vue";
import inputAtendente from "../components/ModalInputAtendente.vue";
import { QTableProps, useQuasar } from "quasar"
import { Atendente } from "../domain/Atendente";
import {listAllAtendente} from "../axios/services/AtendeteService"

const columns: QTableProps['columns'] = [
  {
    name: "nome",
    required: true,
    label: "Cliente",
    align: "left",
    field: "nome",

  },
  {
    name: "E-mail",
    align: "center",
    label: "E-mail",
    field: "email",

  },
  {
    name: "actions",
    label: "Ações",
    field: 'actions'

  },
];

const rows = ref<Atendente[]>([]);
const quasar = useQuasar()

async function getAllAtendente() {
  try {
    quasar.loading.show()
    const resul = await listAllAtendente()
    rows.value = resul
    quasar.loading.hide()

  } catch (error) {
    erroLoading()
  }
}
//função derro ao carregar lista de cliente
function erroLoading() {
  quasar.loading.hide()

  quasar.notify({
    message: "Não foi possivel conectar com Sistema!!!",
    multiLine: true,
    type: 'negative'
  })
}
function loadingAtendete() {
  toolbar.value = false
  getAllAtendente()
}
const toolbar = ref(false);

onMounted(() => {
  getAllAtendente()
})
</script>
<template>
  <div class="container">
    <div class="filho">
      <div>
        <q-table :rows="rows" :columns="columns" row-key="name" color="amber">
          <template v-slot:top>
            <h5>Lista de Atendente</h5>
            <q-space />
            <q-btn class="btn" round color="positive" size="md" icon="add" @click="toolbar = true" />
          </template>
          <template v-slot:body-cell-actions="props">
            <q-td :props="props">
              <q-btn icon="edit" color="info" size="sm" class="q-mr-sm" />
              <q-btn icon="delete" color="negative" size="sm" />
            </q-td>
          </template>
        </q-table>
      </div>
    </div>
    <div>
      <q-dialog  v-model="toolbar">
        <q-card style="width: 1000px; max-width: 80vw;">
          <q-toolbar>
            <q-avatar>
              <img src="https://cdn.quasar.dev/logo-v2/svg/logo.svg" />
            </q-avatar>

            <q-toolbar-title><span class="text-weight-bold">Novo</span> - Atendente</q-toolbar-title>

            <q-btn flat round dense icon="close" v-close-popup />
          </q-toolbar>

          <q-card-section>
            <inputAtendente @create-atendente="loadingAtendete()"></inputAtendente>
          </q-card-section>
        </q-card>
      </q-dialog>
    </div>
  </div>
</template>
<style scoped>
 div {
  margin-bottom: 20px;
}
</style>
