package com.littlegnal.accounting.base.mvibase

import io.reactivex.Observable

/**
 * 代表UI的视图
 * a）将其意图发送到视图模型，
 * b）订阅[MviViewModel]渲染UI。
 *
 * @param <I> 发出的意图[MviIntent]
 * @param <S> 订阅状态[MviViewState]，用于渲染UI.
 * */
interface MviView<I : MviIntent, in S : MviViewState> {
  /**
   * **用户意图**
   * * [MviViewModel]监听该方法所返回的所有用户意图。
   * * 所有用户意图[MviIntent]都需要从该方法发送出去。
   */
  fun intents(): Observable<I>

  /**
   * [MviView]渲染界面的入口，根据返回的[MviViewState]的要求来渲染界面
   */
  fun render(state: S)
}