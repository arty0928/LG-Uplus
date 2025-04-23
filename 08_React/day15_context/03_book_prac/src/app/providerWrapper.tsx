"use client";

import { MemberProvider } from '@/store/member'
import React, { ReactNode } from 'react'

export default function ProviderWrapper({children}: {children : ReactNode}) {
  return (
    <MemberProvider>{ children}</MemberProvider>
  )
}
