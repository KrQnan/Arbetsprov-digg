//Vi skapar en typ som berättar vad vi förväntar oss i en api respons och låter den ta emot valfritt interface i form av en generic
export type APIResponse<T> = {
  sucess: boolean
  content: T
  status?: number
}
